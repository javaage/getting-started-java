/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('GoldenSampleCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', GoldenSampleCtrl])
    .controller('OperateGoldenSampleCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateGoldenSampleCtrl]);
function GoldenSampleCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    var vm = this;
    $scope.goldenSamples = [];
    vm.people = [
        { name: 'Adam',      email: 'adam@email.com',      age: 12, country: 'United States' },
        { name: 'Amalie',    email: 'amalie@email.com',    age: 12, country: 'Argentina' },
        { name: 'Estefanía', email: 'estefania@email.com', age: 21, country: 'Argentina' },
        { name: 'Adrian',    email: 'adrian@email.com',    age: 21, country: 'Ecuador' },
        { name: 'Wladimir',  email: 'wladimir@email.com',  age: 30, country: 'Ecuador' },
        { name: 'Samantha',  email: 'samantha@email.com',  age: 30, country: 'United States' },
        { name: 'Nicole',    email: 'nicole@email.com',    age: 43, country: 'Colombia' },
        { name: 'Natasha',   email: 'natasha@email.com',   age: 54, country: 'Ecuador' },
        { name: 'Michael',   email: 'michael@email.com',   age: 15, country: 'Colombia' },
        { name: 'Nicolás',   email: 'nicolas@email.com',    age: 43, country: 'Colombia' }
    ];
    $scope.getGoldenSampleList = function(){
        services.getGoldenSampleList().then(function(result) {
            if (result.code == 1) {
                $scope.goldenSamples = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 10,           // count per page
                    sorting: { active:'desc', goldenSampleName: 'asc'}
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

    $scope.addGoldenSampleModal = function(){
        //var scope = $rootScope.$new();
        $scope.goldenSample = {};
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'goldenSampleModal.html',
            controller: 'OperateGoldenSampleCtrl',
        });
    };

    $scope.inactiveGoldenSample = function(goldenSample){
        goldenSample.active = false;
        services.updateGoldenSample(goldenSample).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.activeGoldenSample = function(goldenSample){
        goldenSample.active = true;
        services.updateGoldenSample(goldenSample).then(function(result) {
            if (result.code == 1) {
                //alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.updateGoldenSampleModal = function(goldenSample){
        //var scope = $rootScope.$new();
        $scope.goldenSample =goldenSample;
        $scope.isModify = true;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            templateUrl: 'goldenSampleModal.html',
            controller: 'OperateGoldenSampleCtrl',
        });
    };

    $scope.updateGoldenSample = function(goldenSample){
        services.updateGoldenSample(goldenSample).then(function(result) {
            if (result.code == 1) {
                alert("success");
            }
        }, function (error) {
            console.log(error);    
        });
    };

    $scope.getGoldenSampleList();
}

function OperateGoldenSampleCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeGoldenSampleModal = function(){
        $uibModalInstance.dismiss();
    };



    $scope.submitGoldenSampleData = function(){
        	if($scope.isModify){
                services.updateGoldenSample($scope.goldenSample).then(function(result) {
                    if (result.code == 1) {
                        $scope.closeGoldenSampleModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }else{
                services.addGoldenSample($scope.goldenSample).then(function(result) {
                    if (result.code == 1) {
                        $scope.getGoldenSampleList();
                        $scope.closeGoldenSampleModal();
                    }
                }, function (error) {
                    console.log(error);    
                });
            }
    };
    
}