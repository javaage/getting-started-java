angular
    .module('RDash')
    .controller('EmployeeCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', EmployeeCtrl])
    .controller('OperateUserCtrl', ['$scope','$log','$uibModalInstance','app.services', AddUserCtrl]);
function EmployeeCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.users = [];
    $scope.isIDLegal = false;
    $scope.getUserList = function(){
        services.getUserList().then(function(result) {
            if (result.code == 1) {
                $scope.users = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { id: 'asc'}
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

    $scope.addUserModal = function(){
        //var scope = $rootScope.$new();
        $scope.user = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'addUserModal.html',
            controller: 'OperateUserCtrl',
        });
    };

    $scope.inactiveUser = function(user){
        user.active = false;
        services.updateUser(user).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeUser = function(user){
        user.active = true;
        services.updateUser(user).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateUserModal = function(user){
        //var scope = $rootScope.$new();
        $scope.user =user;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'addUserModal.html',
            controller: 'OperateUserCtrl',
        });
    };

    $scope.updateUser = function(user){
        services.updateUser(user).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getUserList();
}

function AddUserCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeUserModal = function(){
        $uibModalInstance.dismiss();
    };

    $scope.checkForm = function(){
        
        return true;
    }

    $scope.submitUserData = function(){
        if($scope.checkForm()){
            if($scope.isModify){
                services.updateUser($scope.user).then(function(result) {
                    if (result.code == 1) {
                        $scope.closeUserModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }else{
                services.addUser($scope.user).then(function(result) {
                    if (result.code == 1) {
                        $scope.getUserList();
                        $scope.closeUserModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }
        }
    };

    
}