(function() {
  'use strict';
  angular.module('petcontrol').service('PessoaService', PessoaService);
  PessoaService.$inject = ['$http'];

  function PessoaService($http) {
    var URL = 'http://localhost:8080/petcontrol/rest/pessoa';

    this.getTodasPessoas = function() {
      return $http.get(URL);
    };

    this.salvar = function(pessoa) {
      return $http.post(URL, pessoa);
    };
  }
})();
