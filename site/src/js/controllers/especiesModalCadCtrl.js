(function() {
  'use strict';
  angular.module('petcontrol').controller('EspeciesModalCadCtrl', EspeciesModalCadCtrl);

  EspeciesModalCadCtrl.$inject = ['$scope', '$uibModalInstance', '$http', '$q', 'EspeciesService'];

  function EspeciesModalCadCtrl($scope, $uibModalInstance, $http, $q, EspeciesService) {
    var vm = this;
    vm.especiesSalvos = [];

    init();

    function init() {
      $q.all([
        refresh()
      ]);
    }

    function refresh() {
      vm.especie = {};
    }

    vm.salvar = function(continuar) {
      EspeciesService.salvar(vm.especie)
        .then(function(result) {
          vm.especiesSalvos.push(angular.copy(result));
          if (!continuar) {
            $uibModalInstance.close(vm.especiesSalvos);
          } else {
            refresh();
          }
        })
        .then(function(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    };

    vm.fechar = function() {
      $uibModalInstance.dismiss('cancel');
    };
  }
})();
