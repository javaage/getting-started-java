/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('RoleCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', RoleCtrl])
    .controller('OperateRoleCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateRoleCtrl]);
function RoleCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.roles = [];

    $scope.getRoleList = function(){
        services.getRoleList().then(function(result) {
            if (result.code == 1) {
                $scope.roles = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', roleName: 'asc'}
                },
                {
                    total: 0, // length of data
                    dataset: result.data
                });
            }
        }, function (error) {
            console.log(error);    
        });       
    }

    $scope.addRoleModal = function(){
        //var scope = $rootScope.$new();
        $scope.role = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'roleModal.html',
            controller: 'OperateRoleCtrl',
        });
    };

    $scope.inactiveRole = function(role){
        role.active = false;
        services.updateRole(role).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeRole = function(role){
        role.active = true;
        services.updateRole(role).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateRoleModal = function(role){
        //var scope = $rootScope.$new();
        $scope.role =role;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'roleModal.html',
            controller: 'OperateRoleCtrl',
        });
    };

    $scope.updateRole = function(role){
        services.updateRole(role).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getRoleList();
}

function OperateRoleCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeRoleModal = function(){
        $uibModalInstance.dismiss();
    };



    $scope.submitRoleData = function(){
        $scope.dataLoading = true;
        	if($scope.isModify){
                services.updateRole($scope.role).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getRoleList();
                        $scope.closeRoleModal();
                    }
                }, function (error) {
                    $scope.dataLoading = false;
                    console.log(error);    
                });
            }else{
                services.addRole($scope.role).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getRoleList();
                        $scope.closeRoleModal();
                    }
                }, function (error) {
                    $scope.dataLoading = false;
                    console.log(error);    
                });
            }
    };
    
}