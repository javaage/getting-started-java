(function () {
    'use strict';

    angular
        .module('RDash')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$scope','$location', 'AuthenticationService'];
    function LoginController($scope, $location, AuthenticationService) {
        $scope.vm = {};

        AuthenticationService.ClearCredentials();

        $scope.login = function() {
            $scope.vm.dataLoading = true;
            AuthenticationService.Login($scope.vm.username, $scope.vm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials($scope.vm.username, $scope.vm.password);
                    $location.path('/');
                } else {
                    $scope.vm.dataLoading = false;
                }
            });
        };
    }

})();
