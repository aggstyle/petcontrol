(function () {
  'use strict';
	angular.module('petcontrol').controller('InicialCtrl',   ['$q','AnimalService','NgTableParams','$scope','$uibModal','$http','EspeciesService',InicialCtrl]);

  function InicialCtrl($q,AnimalService,NgTableParams, $scope,$uibModal,$http,EspeciesService) {
    var vm = this;
    vm.doacoes = [];
    function carregarDoacao() {
        return AnimalService.getAdocaoAnimais()
          .then(function succes(result) {
            vm.doacoes = result.data;
          }, function error(result) {
            console.log('error carregarAnimais:', result);
          });
      }
   
    init();
    function init() {
      $q.all([
              carregarDoacao()
        ])
        .then(function() {
          refresh();
        });
    }
    vm.openModal = _openModal;
	  vm.especies = [{'id':'teste1','title': 'teste1'},{'id':'teste','title': 'teste'},{'id':'teste3','title': 'teste3'}];//TODO fazer um resource para disponibilizar lista de especies
		vm.ongs = [{'id':'ong1','title': 'ong1'},{'id':'ong','title': 'ong'},{'id':'ong3','title': 'ong3'}];//TODO fazer um resource para disponibilizar lista de ongs

    function refresh() {
      vm.tableAnimais = new NgTableParams({
        count: 10
      }, {
        dataset:  vm.doacoes
      });
     }


    
    console.log('animais',vm.doacoes);
    refresh();
    
    function _openModal(size){
      var modalInstance = $uibModal.open({
      animation: true,
      templateUrl: 'templates/animaisModalView.html',
      controller: 'AnimaisModalViewCtrl',
      scope: $scope,
      size: size,
      resolve: {
        items: function () {
          return vm.rfid;
        }
        }
    });
    modalInstance.result.then(function (selectedItem) {
      vm.selected = selectedItem;
    }, function () {});
    }
  }
})();
