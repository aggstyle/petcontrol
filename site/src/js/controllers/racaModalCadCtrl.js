(function() {
  'use strict';
  angular.module('petcontrol').controller('RacasModalCadCtrl', RacasModalCadCtrl);

  RacasModalCadCtrl.$inject = ['$scope', '$uibModalInstance', '$http', '$q', 'RacasService'];

  function RacasModalCadCtrl($scope, $uibModalInstance, $http, $q, RacasService) {
    var vm = this;
    vm.racasSalvos = [];

    init();

    function init() {
      $q.all([
        refresh()
      ]);
    }

    function refresh() {
      vm.raca = {};
    }

    vm.salvar = function(continuar) {
      RacasService.salvar(vm.raca)
        .then(function(result) {
          console.log(result);
          vm.racasSalvos.push(angular.copy(result.data));
          if (!continuar) {
            $uibModalInstance.close(vm.racasSalvos);
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
