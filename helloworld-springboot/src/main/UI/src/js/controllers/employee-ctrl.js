/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('EmployeeCtrl', ['$scope', EmployeeCtrl]);

function EmployeeCtrl($scope) {
    $scope.message = "welcome";
}