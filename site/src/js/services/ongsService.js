(function() {
  'use strict';
  angular.module('petcontrol').service('OngService', OngService);
  OngService.$inject = ['$http'];

  function OngService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/ong';

    this.getTodasOngs = function() {
      return $http.get(URL);
    };

    this.salvar = function(ong) {
      return $http.post(URL, ong);
    };
  }
})();
