(function() {
  'use strict';
  angular.module('petcontrol').controller('CoresModalCadCtrl', CoresModalCadCtrl);

  CoresModalCadCtrl.$inject = ['$scope', '$uibModalInstance', '$http', '$q', 'CoresService'];

  function CoresModalCadCtrl($scope, $uibModalInstance, $http, $q, CoresService) {
    var vm = this;
    vm.coresSalvos = [];

    init();

    function init() {
      $q.all([
        refresh()
      ]);
    }

    function refresh() {
      vm.cor = {};
    }

    vm.salvar = function(continuar) {
      CoresService.salvar(vm.cor)
        .then(function(result) {
          vm.coresSalvos.push(angular.copy(result));
          if (!continuar) {
            $uibModalInstance.close(vm.coresSalvos);
          } else {
            refresh();
          }
        }, function(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });

    };

    vm.fechar = function() {
      $uibModalInstance.dismiss('cancel');
    };
  }
})();
