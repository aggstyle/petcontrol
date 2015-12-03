(function() {
  'use strict';
  angular.module('petcontrol').controller('AnimaisModalCadCtrl', AnimaisModalCadCtrl);

  AnimaisModalCadCtrl.$inject = ['$scope', '$uibModalInstance', '$http', '$q', 'EspeciesService', '$uibModal', 'RacasService', 'CoresService', 'item', 'AnimalService', 'OngService', 'PessoaService'];

  function AnimaisModalCadCtrl($scope, $uibModalInstance, $http, $q, EspeciesService, $uibModal, RacasService, CoresService, animalEdit, AnimalService, OngService, PessoaService) {
    var vm = this;
    vm.especiesSelect = [];
    vm.animaisSalvos = [];
    vm.racasSelect = [];
    vm.coresSelect = [];
    vm.ongsSelect = [];
    vm.openModalCadEspecie = _openModalCadEspecie;
    vm.openModalCadRaca = _openModalCadRaca;
    vm.openModalCadCor = _openModalCadCor;
    vm.editando = animalEdit && animalEdit.id;
    vm.tituloPage = _tituloPage;
    vm.animais = [];
    vm.pessoas = [];

    function _openModalCadEspecie() {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/especiesModalCad.html',
        controller: 'EspeciesModalCadCtrl as vm'
      });
      modalInstance.result.then(function(result) {
        vm.especiesSelect = vm.especiesSelect.concat(result);
      });
    }

    function _openModalCadRaca() {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/racasModalCad.html',
        controller: 'RacasModalCadCtrl as vm'
      });
      modalInstance.result.then(function(result) {
        vm.racasSelect = vm.racasSelect.concat(result);
      });
    }

    function _openModalCadCor() {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/coresModalCad.html',
        controller: 'CoresModalCadCtrl as vm'
      });
      modalInstance.result.then(function(result) {
        vm.coresSelect = vm.coresSelect.concat(result);
      });
    }

    init();

    function init() {
      carregarRacas();
      $q.all([
          carregarEspecies(),
          carregarRacas(),
          carregarCores(),
          carregarOngs(),
          carregarAnimais(),
          carregarPessoas()
        ])
        .then(function() {
          refresh();
        });
    }

    function refresh() {
      vm.animal = animalEdit ? animalEdit : {};
    }

    function carregarPessoas() {
      return PessoaService.getTodasPessoas()
        .then(function successCallback(result) {
          vm.pessoas = result.data;
        }, function errorCallback(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    }

    function carregarAnimais() {
      return AnimalService.getTodosAnimais()
        .then(function successCallback(result) {
          vm.animais = result.data;
        }, function errorCallback(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    }

    function carregarEspecies() {
      return EspeciesService.getTodasEspecies()
        .then(function successCallback(result) {
          vm.especiesSelect = result.data;
        }, function errorCallback(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    }

    function carregarRacas() {
      return RacasService.getTodasRacas()
        .then(function successCallback(result) {
          vm.racasSelect = result.data;
        }, function errorCallback(result) {
          alert('Ocorreu um erro ', result);
          console.log('erro ', result);
        });
    }

    function carregarCores() {
      return CoresService.getTodasCores()
        .then(function successCallback(result) {
          vm.coresSelect = result.data;
        }, function errorCallback(result) {
          console.log('erro ', result);
        });
    }

    function carregarOngs() {
      return OngService.getTodasOngs()
        .then(function successCallback(result) {
          vm.ongsSelect = result.data;
        }, function errorCallback(result) {
          console.log('erro ', result);
        });
    }

    vm.salvar = function(continuar) {

      salvarEspecie().then(function() {
        salvarRaca().then(function() {

          salvarCor().then(function() {

            salvarOng().then(function() {
              salvarAnimal().then(function() {
                vm.animaisSalvos.push(angular.copy(vm.animal));
                if (!continuar) {
                  $uibModalInstance.close(vm.animaisSalvos);
                } else {
                  refresh();
                }
              });
            });
          });
        });
      });
    };

    vm.fechar = function() {
      $uibModalInstance.dismiss('cancel');
    };

    function salvarEspecie() {
      var promise = $q.when();
      if (!vm.animal.especie.id) {
        var especie = {
          'descricao': vm.animal.especie
        };
        promise = EspeciesService.salvar(especie)
          .then(function(result) {
            vm.especiesSelect.push(angular.copy(result.data));
            vm.animal.especie = result.data;

          }, function(result) {
            //alert('Ocorreu um erro salvarEspecie ', result);
            console.log('erro salvarEspecie', result);
          });
      }

      return promise;
    }

    function salvarRaca() {
      var promise = $q.when();
      if (!vm.animal.raca.id) {

        var raca = {
          'descricao': vm.animal.raca
        };
        promise = RacasService.salvar(raca)
          .then(function(result) {
            vm.racasSelect.push(angular.copy(result.data));
            vm.animal.raca = result.data;

          }, function(result) {
            console.log('erro ', result);
          });
      }

      return promise;
    }

    function salvarCor() {
      var promise = $q.when();
      if (!vm.animal.cor.id) {
        var cor = {
          'descricao': vm.animal.cor
        };
        promise = CoresService.salvar(cor)
          .then(function(result) {
            vm.coresSelect.push(angular.copy(result.data));
            vm.animal.cor = result.data;

          }, function(result) {
            console.log('erro ', result);
          });
      }

      return promise;
    }

    function salvarOng() {
      var promise = $q.when();
      if (!vm.animal.ong.id) {
        var ong = {
          'nome': vm.animal.ong
        };
        promise = OngService.salvar(ong)
          .then(function(result) {
            vm.ongsSelect.push(angular.copy(result.data));
            vm.animal.ong = result.data;

          }, function(result) {
            console.log('erro ', result);
          });
      }

      return promise;
    }

    function salvarAnimal() {
      var promise = AnimalService.salvar(vm.animal)
        .then(function success(result) {
          vm.animal = result.data;
        }, function error(result) {
          console.log('erro salvarAnimal: ', result);
        });

      return promise;
    }

    function _tituloPage() {
      return vm.editando ? 'Editando os dados deste animal' : 'Cadastrando um novo animal';
    }

  }
})();
