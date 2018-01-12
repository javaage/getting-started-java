/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('SampleCtrl', ['$scope', SampleCtrl]);

function SampleCtrl($scope) {
    $scope.message = "welcome";
}