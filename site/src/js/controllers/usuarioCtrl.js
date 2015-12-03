(function() {
  'use strict';
  angular.module('petcontrol').controller('UsuarioCtrl', UsuarioCtrl);

  UsuarioCtrl.$inject = ['NgTableParams', '$scope', '$uibModal'];

  function UsuarioCtrl(NgTableParams, $scope, $uibModal) {
    var vm = this;
    vm.openModal = _openModal;

    var data = [];

    init();

    function init() {
      refresh();
    }

    function refresh() {
      vm.tableusuario = new NgTableParams({
        count: 10
      }, {
        dataset: data
      });
    }

    function _openModal(size) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'templates/usuarioModalCad.html',
        controller: 'UsuarioModalCadCtrl as vm',
        size: size
      });

      modalInstance.result.then(function(result) {
        data = data.concat(result);
        refresh();
      }, function() {
        //$log.info('Modal dismissed at: ' + new Date());
      });
    }
  }
})();
