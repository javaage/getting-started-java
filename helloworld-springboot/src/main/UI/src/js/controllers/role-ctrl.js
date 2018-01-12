/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('RoleCtrl', ['$scope', RoleCtrl]);

function RoleCtrl($scope) {
    $scope.message = "welcome";
}