/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('FlyerCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', FlyerCtrl])
    .controller('OperateFlyerCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateFlyerCtrl]);
function FlyerCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.flyers = [];

    $scope.getFlyerList = function(){
        services.getFlyerList().then(function(result) {
            if (result.code == 1) {
                $scope.flyers = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', flyerName: 'asc'}
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
        //var scope = $rootScope.$new();
        $scope.flyer = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'flyerModal.html',
            controller: 'OperateFlyerCtrl',
        });
    };

    $scope.inactiveFlyer = function(flyer){
        flyer.active = false;
        services.updateFlyer(flyer).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeFlyer = function(flyer){
        flyer.active = true;
        services.updateFlyer(flyer).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateFlyerModal = function(flyer){
        //var scope = $rootScope.$new();
        $scope.flyer =flyer;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'flyerModal.html',
            controller: 'OperateFlyerCtrl',
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

    $scope.getFlyerList();
}

function OperateFlyerCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeFlyerModal = function(){
        $uibModalInstance.dismiss();
    };



    $scope.submitFlyerData = function(){
        	if($scope.isModify){
                services.updateFlyer($scope.flyer).then(function(result) {
                    if (result.code == 1) {
                        $scope.getFlyerList();
                        $scope.closeFlyerModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }else{
                services.addFlyer($scope.flyer).then(function(result) {
                    if (result.code == 1) {
                        $scope.getFlyerList();
                        $scope.closeFlyerModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }
    };
    
}