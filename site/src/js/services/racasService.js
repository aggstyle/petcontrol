(function() {
  'use strict';
  angular.module('petcontrol').service('RacasService', RacasService);
  RacasService.$inject = ['$http'];

  function RacasService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/raca';

    this.getTodasRacas = function() {
      return $http.get(URL);
    };
    this.salvar = function(cor) {
      return $http.post(URL,cor);
    };
  }
})();
