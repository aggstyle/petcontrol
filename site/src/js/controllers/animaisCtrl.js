(function() {
  'use strict';
  angular.module('petcontrol').controller('AnimaisCtrl', AnimaisCtrl);

  AnimaisCtrl.$inject = ['NgTableParams', '$scope', '$uibModal', '$q', 'AnimalService'];

  function AnimaisCtrl(NgTableParams, $scope, $uibModal, $q, AnimalService) {
    var vm = this;
    vm.openModal = _openModal;
    vm.editarAnimal = _editarAnimal;
    vm.removerAnimal = _removerAnimal;
    vm.animais = [];

    init();

    function init() {
      $q.all([
          carregarAnimais()
        ])
        .then(function() {
          refresh();
        });
    }


    function carregarAnimais() {
      return AnimalService.getTodosAnimais()
        .then(function succes(result) {
          vm.animais = result.data;
        }, function error(result) {
          console.log('error carregarAnimais:', result);
        });
    }

    function refresh() {

      vm.tableAnimais = new NgTableParams({
        count: 10
      }, {
        dataset: vm.animais
      });
    }

    function _openModal(animal) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/animaisModalCad.html',
        controller: 'AnimaisModalCadCtrl as vm',
        resolve: {
          item: angular.copy(animal),
        }
      });

      modalInstance.result.then(function(result) {

        angular.forEach(result,function(a){
          console.log(a);
          var animalNovo = vm.animais.some(function(ani){
            return ani.id === a.id;
          });
          console.log(a.id);
          console.log(animalNovo);
          if(!animalNovo){
            vm.animais.push(a);
          }else{
              angular.forEach(vm.animais,function(ani){
                if(ani.id === a.id){
                  angular.extend(ani,a);
                  console.log('encontrou', ani);
                }
              });
          }
        });
        console.log('animais',vm.animais);
        refresh();
      });
    }

    function _editarAnimal(animal) {
      _openModal(animal);
    }

    function _removerAnimal(animal) {
      AnimalService.deletar(animal);
    }

  }
})();
