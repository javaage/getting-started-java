/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('AuthCtrl', ['$rootScope', '$scope','$log','$uibModal','AuthenticationService', '$state', AuthCtrl]);
function AuthCtrl($rootScope, $scope, $log,$uibModal, AuthenticationService, $state) {
    if(!AuthenticationService.GetCredentials()){
        $state.go('login');
    }
}

