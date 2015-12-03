(function() {
  'use strict';
  angular.module('petcontrol').service('CoresService', CoresService);
  CoresService.$inject = ['$http'];

  function CoresService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/cor';

    this.getTodasCores = function() {
      return $http.get(URL);
    };

    this.salvar = function(cor) {
      return $http.post(URL,cor);
    };
  }
})();
