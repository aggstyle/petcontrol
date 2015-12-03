(function() {
  'use strict';
  angular.module('petcontrol').service('EspeciesService', EspeciesService);
  EspeciesService.$inject = ['$http'];

  function EspeciesService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/especie';

    this.getTodasEspecies = function() {
      return $http.get(URL);
    };
    this.salvar = function(cor) {
      return $http.post(URL,cor);
    };
  }
})();
