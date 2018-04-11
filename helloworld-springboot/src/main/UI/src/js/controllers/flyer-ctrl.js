/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('FlyerCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', '$filter', FlyerCtrl])
    .controller('OperateFlyerCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateFlyerCtrl]);
function FlyerCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams, $filter) {    
    $scope.roles = [];
    $scope.users = [];
    $scope.GMT = services.getGMT();

    $scope.flyers = [];

    $scope.getFlyerList = function(){
        services.getFlyerList().then(function(result) {
            if (result.code == 1) {
                $scope.flyers = result.data;

                angular.forEach($scope.flyers, function (item, index) {
                    if(item.audienceType == 'R'){
                        item.audienceTypeValue = 'By Role';
                    }else if(item.audienceType == 'U'){
                        item.audienceTypeValue = 'By User';
                    }
                });

                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', id: 'asc'}
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

    $scope.addFlyerModal = function(){
        $scope.flyer = {};
        $scope.isModify = false;

        $scope.flyer.activeTime = $filter('date')(new Date(),'yyyy-MM-dd HH:mm', $scope.GMT);
        $scope.flyer.audienceType = 'R';

        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            size: 'lg',
            templateUrl: 'flyerModal.html',
            controller: 'OperateFlyerCtrl',
        });
    };

    $scope.inactiveFlyer = function(flyer){
        flyer.active = false;
        services.updateFlyerOnly(flyer).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeFlyer = function(flyer){
        flyer.active = true;
        services.updateFlyerOnly(flyer).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateFlyerModal = function(flyer){
        $scope.isModify = true;
        services.getFlyer(flyer.id).then(function(result) {
            if (result.code == 1) {
                $scope.flyer = result.data;

                $scope.flyer.activeTime =  $filter('date')( $scope.flyer.activeTime ,'yyyy-MM-dd HH:mm', $scope.GMT);

                if($scope.flyer.audienceType == 'R'){
                    $scope.flyer.roleList=$scope.flyer.listRoleModel;
                }else{
                    $scope.flyer.userList=$scope.flyer.listUserModel;
                }

                var modalInstance = $uibModal.open({
                    scope: $scope,
                    animation: true,
                    size: 'lg',
                    templateUrl: 'flyerModal.html',
                    controller: 'OperateFlyerCtrl',
                });
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateFlyer = function(flyer){
        services.updateFlyer(flyer).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

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
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.init = function(){
        $scope.getFlyerList();

        $scope.getRoleList();
        $scope.getUserList();
        
    };

    $scope.init();
}

function OperateFlyerCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeFlyerModal = function(){
        $uibModalInstance.dismiss();
    };



    $scope.submitFlyerData = function(){
        var list = [];
        $scope.dataLoading = true;
        if($scope.flyer.audienceType=='R'){
            for(var i = 0; i < $scope.flyer.roleList.length; i++){
                list.push($scope.flyer.roleList[i].id);
            }
        }else{
            for(var i = 0; i < $scope.flyer.userList.length; i++){
                list.push($scope.flyer.userList[i].id);
            }
        }

        $scope.flyer.audienceList = list.join(',');

        	if($scope.isModify){
                services.updateFlyer($scope.flyer).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getFlyerList();
                        $scope.closeFlyerModal();
                    }
                }, function (error) {
                    $scope.dataLoading = false;
                    console.log(error);    
                });
            }else{
                services.addFlyer($scope.flyer).then(function(result) {
                    $scope.dataLoading = false;
                    if (result.code == 1) {
                        $scope.getFlyerList();
                        $scope.closeFlyerModal();
                    }
                }, function (error) {
                    $scope.dataLoading = false;
                    console.log(error);    
                });
            }
    };
    
}