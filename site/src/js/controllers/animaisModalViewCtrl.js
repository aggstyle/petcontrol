(function () {
  'use strict';
  angular.module('petcontrol').controller('AnimaisModalViewCtrl', AnimaisModalViewCtrl);

  AnimaisModalViewCtrl.$inject = ['$scope', '$uibModalInstance', '$http','items'];
 
  function AnimaisModalViewCtrl($scope, $uibModalInstance,$http,items) {

        $http.get('rest/animal/RFID/'+items).
       success(function (data) {
        $scope.data = data;
      });
                                                                                                             

    $scope.fechar = function () {
      $uibModalInstance.dismiss('cancel');
    };
 
  }
})();
