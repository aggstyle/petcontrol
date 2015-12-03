(function () {
  'use strict';
  angular.module('petcontrol').controller('PessoaModalCadCtrl', PessoaModalCadCtrl);

  PessoaModalCadCtrl.$inject = ['$scope', '$uibModalInstance', '$http', '$q', 'EspeciesService', '$uibModal', 'CidadeService', 'PessoaService','item'];

  function PessoaModalCadCtrl($scope, $uibModalInstance, $http, $q, EspeciesService, $uibModal, CidadeService,  PessoaService,pessoaEdit) {

    var vm = this;
    vm.cidadeSelect = [];
    vm.editando = pessoaEdit && pessoaEdit.id;
    vm.tituloPage = _tituloPage;
    vm.pessoas = [];
    vm.pessoasSalvos = [];

    init();

    function init() {
      $q.all([
        carregarPessoas()
      ])
        .then(function () {
          refresh();
        });
    }

    function refresh() {
      vm.pessoa = pessoaEdit ? pessoaEdit : {};
    }

    function carregarPessoas() {
      return PessoaService.getTodasPessoas()
        .then(function successCallback(result) {
          vm.pessoas = result.data;
        }, function errorCallback(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    }

    vm.salvar = function (continuar) {
      vm.pessoasSalvos.push(angular.copy(vm.pessoa));
      if (!continuar) {
        $uibModalInstance.close(vm.pessoasSalvos);
      } else {
        refresh();
      }

    };

    vm.fechar = function () {
      $uibModalInstance.dismiss('cancel');
    };

    function salvarPessoa() {
      var promise = PessoaService.salvar(vm.pessoa)
        .then(function success(result) {
          vm.pessoa = result.data;
        }, function error(result) {
          console.log('erro salvarPessoa: ', result);
        });

      return promise;
    }

    function _tituloPage() {
      return vm.editando ? 'Editando os dados deste Pessoa' : 'Cadastrando um novo Pessoa';
    }

  }
})();
