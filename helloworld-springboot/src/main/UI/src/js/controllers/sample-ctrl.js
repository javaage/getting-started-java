/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('GoldenSampleCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', GoldenSampleCtrl])
    .controller('OperateGoldenSampleCtrl', ['$scope','$log','$uibModalInstance','app.services', OperateGoldenSampleCtrl]);
function GoldenSampleCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    
    $scope.goldenSamples = [];

    $scope.getRoleList = function(){
        services.getRoleList().then(function(result) {
            if (result.code == 1) {
                $scope.roles = result.data;
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.getCourseList = function(){
        services.getCourseList().then(function(result) {
            if (result.code == 1) {
                $scope.courses = result.data;
            }
        }, function (error) {
            console.log(error);    
        });       
    };

    $scope.getGoldenSampleList = function(){
        services.getGoldenSampleList().then(function(result) {
            if (result.code == 1) {
                $scope.goldenSamples = result.data;
                $scope.tableParams = new NgTableParams(
                {
                    page: 1,            // show first page
                    count: 4,           // count per page
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
    };



    $scope.addGoldenSampleModal = function(){
        //var scope = $rootScope.$new();
        $scope.goldenSample = {};
        $scope.goldenSample.roleID = $scope.roles[0].id;
        $scope.isModify = false;
        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            size: 'lg',
            width:800,
            height: 600,
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

    Array.prototype.contains = function (obj) {  
        var i = this.length;  
        while (i--) {  
            if (this[i] == obj) {  
                return true;  
            }  
        }  
        return false;  
    };  

    var loadCourseCode = function(){
        var mandatory = $scope.goldenSample.mandatory.split(',');
        var optional = $scope.goldenSample.optional.split(',');

        $scope.goldenSample.mandatoryCourse = [];
        $scope.goldenSample.optionalCourse = [];

        for(var index in $scope.courses){
            if(mandatory.contains($scope.courses[index].id))
                $scope.goldenSample.mandatoryCourse.push($scope.courses[index]);
            if(optional.contains($scope.courses[index].id))
                $scope.goldenSample.optionalCourse.push($scope.courses[index]);
        }
    };

    $scope.updateGoldenSampleModal = function(goldenSample){
        //var scope = $rootScope.$new();
        $scope.goldenSample = goldenSample;
        $scope.isModify = true;
        loadCourseCode();

        var modalInstance = $uibModal.open({
            scope: $scope,
            animation: true,
            size: 'lg',
            width:800,
            height: 600,
            templateUrl: 'goldenSampleModal.html',
            controller: 'OperateGoldenSampleCtrl',
        });

        modalInstance.opened.then(function(){
            
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

    $scope.deleteGoldenSampleByID = function(id){
        if(confirm('Are you sure you want to delete?')){
            services.deleteGoldenSampleByID(id).then(function(result) {
                if (result.code == 1) {
                    $scope.getGoldenSampleList();
                }
            }, function (error) {
                console.log(error);    
            });
        }
        
    };

    $scope.getRoleList();
    $scope.getCourseList();
    $scope.getGoldenSampleList();
}

function OperateGoldenSampleCtrl($scope, $log,$uibModalInstance, services) { 


    $scope.closeGoldenSampleModal = function(){
        $uibModalInstance.dismiss();
    };

    var getCourseCode = function(){
        var mandatory = [];
        var optional = [];
        for(var index in $scope.goldenSample.mandatoryCourse){
            mandatory.push($scope.goldenSample.mandatoryCourse[index].id);
        }
        for(var index in $scope.goldenSample.optionalCourse){
            optional.push($scope.goldenSample.optionalCourse[index].id);
        }

        $scope.goldenSample.mandatory = mandatory.join(',');
        $scope.goldenSample.optional = optional.join(',');
    };

    $scope.submitGoldenSampleData = function(){
            getCourseCode();
        	if($scope.isModify){
                services.updateGoldenSample($scope.goldenSample).then(function(result) {
                    if (result.code == 1) {
                        $scope.getGoldenSampleList();
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