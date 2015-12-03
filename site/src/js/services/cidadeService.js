(function() {
  'use strict';
  angular.module('petcontrol').service('CidadeService', CidadeService);
  CidadeService.$inject = ['$http'];

  function CidadeService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/cidade';

    this.getTodasCores = function() {
      return $http.get(URL);
    };

    this.salvar = function(cor) {
      return $http.post(URL,cor);
    };
  }
})();
