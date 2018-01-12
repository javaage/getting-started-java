/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('CourseCtrl', ['$scope', CourseCtrl]);

function CourseCtrl($scope) {
    $scope.message = "welcome";
}