(function() {
  'use strict';
  angular.module('petcontrol').service('AnimalService', AnimalService);
  AnimalService.$inject = ['$http'];

  function AnimalService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/animal';

    this.getTodosAnimais = function() {
      return $http.get(URL);
    };

    this.getAdocaoAnimais = function() {
      return $http.get('http://localhost:8080/petcontrol/rest/animal/adocao');
    };
    
    this.salvar = function(animal) {
      return $http.post(URL, animal);
    };

    this.deletar = function(animal){
      return $http.delete(URL,{'animal':animal});
    };
  }
})();
