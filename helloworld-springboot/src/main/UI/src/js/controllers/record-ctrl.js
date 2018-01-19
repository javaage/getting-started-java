/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('RecordCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', RecordCtrl])
    .controller('OperateRecordCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateRecordCtrl]);
function RecordCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.records = [];

    $scope.getRecordList = function(){
        services.getRecordList().then(function(result) {
            if (result.code == 1) {
                $scope.records = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', recordName: 'asc'}
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

    $scope.addRecordModal = function(){
        //var scope = $rootScope.$new();
        $scope.record = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'recordModal.html',
            controller: 'OperateRecordCtrl',
        });
    };

    $scope.inactiveRecord = function(record){
        record.active = false;
        services.updateRecord(record).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeRecord = function(record){
        record.active = true;
        services.updateRecord(record).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateRecordModal = function(record){
        //var scope = $rootScope.$new();
        $scope.record =record;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'recordModal.html',
            controller: 'OperateRecordCtrl',
        });
    };

    $scope.updateRecord = function(record){
        services.updateRecord(record).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getRecordList();
}

function OperateRecordCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeRecordModal = function(){
        $uibModalInstance.dismiss();
    };



    $scope.submitRecordData = function(){
        	if($scope.isModify){
                services.updateRecord($scope.record).then(function(result) {
                    if (result.code == 1) {
                        $scope.closeRecordModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }else{
                services.addRecord($scope.record).then(function(result) {
                    if (result.code == 1) {
                        $scope.getRecordList();
                        $scope.closeRecordModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }
    };
    
}