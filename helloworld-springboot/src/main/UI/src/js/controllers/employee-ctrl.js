angular
    .module('RDash')
    .controller('EmployeeCtrl', ['$scope','app.environments','app.services', EmployeeCtrl]);

function EmployeeCtrl($scope,environments,services) {

	services.getUserList().then(function(result) {
        
        if (result.code == 1) {
            $scope.users = result.data;
        }
    }, function (error) {
        console.log(error);    
    });

    $scope.submitUser = function(){

    };
}