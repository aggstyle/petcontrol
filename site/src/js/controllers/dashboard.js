(function () {
  'use strict';
  angular.module('petcontrol').controller('DashboardCtrl', DashboardCtrl);

  DashboardCtrl.$inject = ['$scope', '$http', 'AnimalService'];

  function DashboardCtrl($scope, $http, AnimalService) {
    var vm = this;


    function carregarDoacao() {
      return AnimalService.getAdocaoAnimais()
        .then(function succes(result) {
          vm.doacoes = result.data.length;

        }, function error(result) {
          console.log('error carregarAnimais:', result);
        });
    }

    function carregarAnimais() {
      return AnimalService.getTodosAnimais()
        .then(function succes(result) {
          vm.cadastros = result.data.length;

        }, function error(result) {
          console.log('error carregarAnimais:', result);
        });
    }

    carregarAnimais();
    carregarDoacao()

  }
})();

