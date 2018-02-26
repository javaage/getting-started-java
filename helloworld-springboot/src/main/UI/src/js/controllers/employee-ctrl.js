angular
    .module('RDash')
    .controller('EmployeeCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', EmployeeCtrl])
    .controller('OperateUserCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateUserCtrl])
    .controller('RoleHistoryCtrl', ['$scope','$log','$uibModalInstance','app.services', RoleHistoryCtrl]);
function EmployeeCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    
    $scope.users = [];
    $scope.roles = [];
    $scope.isIDLegal = false;

    $scope.getRoleList = function(){
        services.getRoleList().then(function(result) {
            if (result.code == 1) {
                $scope.roles = result.data;
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.getUserList = function(){
        services.getUserList().then(function(result) {
            if (result.code == 1) {
                $scope.users = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active: 'desc', id: 'asc'}
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
        $scope.userView = false;
        $scope.user = {};
        $scope.user.roleID = '';
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'templates/userModal.html',
            controller: 'OperateUserCtrl',
        });
    };

    $scope.getRoleHistoryListByUserID = function(userID){
        services.getRoleHistoryListByUserID(userID).then(function(result) {
            if (result.code == 1) {
                $scope.histories = result.data;
                $scope.tableHistoryParams = new NgTableParams(
                    {
                        page: 1,            // show first page
                        count: 10,           // count per page
                        sorting: { updateTime: 'desc'}
                    },
                    {
                        total: 0, // length of data
                        dataset: result.data
                    });
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getCourseHistoryListByUserID = function(userID){
        services.getCourseHistoryListByUserID(userID).then(function(result) {
            if (result.code == 1) {
                $scope.courses = result.data;
                $scope.tableCoursesParams = new NgTableParams(
                    {
                        page: 1,            // show first page
                        count: 10,           // count per page
                        sorting: { updateTime: 'desc'}
                    },
                    {
                        total: 0, // length of data
                        dataset: result.data
                    });
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getHistoryModal = function(user){
        $scope.user = user;
        $scope.getRoleHistoryListByUserID($scope.user.id);
        
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'templates/historyModal.html',
            controller: 'RoleHistoryCtrl',
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

            }
        }, function (error) {
            console.log(error);    
        });
    };
    
    $scope.viewUserModal = function(user){
        $scope.userView = true;
        $scope.user =user;
        $scope.isModify = true;
        $scope.getRoleHistoryListByUserID($scope.user.id);
        $scope.getCourseHistoryListByUserID($scope.user.id);
        
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'templates/userModal.html',
            controller: 'OperateUserCtrl',
        });
    };

    $scope.updateUserModal = function(user){
        $scope.userView = false;
        $scope.user =user;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'templates/userModal.html',
            controller: 'OperateUserCtrl',
        });
    };

    $scope.showCourseHistory = function(user){

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
    $scope.getRoleList();
    $scope.getUserList();
}

function OperateUserCtrl($scope, $log,$uibModalInstance, services) { 

    $scope.closeUserModal = function(){
        $uibModalInstance.dismiss();
    };

    $scope.checkUserID = function(id){
        services.checkUser(id).then(function(result) {
            if (result.code == 1) {
                if(result.data == true){
                    $scope.userForm.id.$setValidity('acountvalid', true);
                    $scope.userForm.id.$invalid = false;

                }else{
                    $scope.userForm.id.$setValidity('acountvalid', false);
                    $scope.userForm.id.$invalid = true;
                }
            }
        }, function (error) {
            console.log(error);    
        });
    }
    
    $scope.submitUserData = function(){
        if($scope.isModify){
            services.updateUser($scope.user).then(function(result) {
                    if (result.code == 1) {
                        $scope.getUserList();
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
    };
}

function RoleHistoryCtrl($scope, $log,$uibModalInstance, services) { 
    
    
    $scope.closeHistoryModal = function(){
        $uibModalInstance.dismiss();
    };
    
}