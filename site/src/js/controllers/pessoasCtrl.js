(function() {
  'use strict';
  angular.module('petcontrol').controller('PessoasCtrl', PessoasCtrl);

  PessoasCtrl.$inject = ['NgTableParams', '$scope', '$uibModal','PessoaService'];

  function PessoasCtrl(NgTableParams, $scope, $uibModal,PessoaService) {
    var vm = this;
    vm.openModal = _openModal;
    vm.editarPessoa = _editarPessoa;
    vm.removerPessoa = _removerPessoa;
    vm.pessoa = [];
    var data = [];

    init();

    function init() {
      refresh();
    }

    function refresh() {
      vm.tablePessoas = new NgTableParams({
        count: 10
      }, {
        dataset: data
      });
    }
    
    function _editarPessoa(pessoa) {
      _openModal(pessoa);
    }

    function _removerPessoa(pessoa) {
      PessoaService.deletar(pessoa);
    }

    function _openModal(pessoa) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/pessoaModalCad.html',
        controller: 'PessoaModalCadCtrl as vm',
        resolve: {
          item: angular.copy(pessoa),
        }
      });

       modalInstance.result.then(function(result) {

        angular.forEach(result,function(a){
          console.log(a);
          var PessoaNovo = vm.pessoa.some(function(ani){
            return ani.id === a.id;
          });
          console.log(a.id);
          console.log(PessoaNovo);
          if(!PessoaNovo){
            vm.pessoa.push(a);
          }else{
              angular.forEach(vm.pessoa,function(ani){
                if(ani.id === a.id){
                  angular.extend(ani,a);
                  console.log('encontrou', ani);
                }
              });
          }
        });
        console.log('pessoa',vm.pessoa);
        refresh();
      });
    }
  }
})();