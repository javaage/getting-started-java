/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('SettingCtrl', ['$rootScope', '$scope','$log','$uibModal','app.services','NgTableParams', SettingCtrl]);
function SettingCtrl($rootScope, $scope, $log,$uibModal, services,NgTableParams) {
    $scope.fileChanged = function(ele){
        $scope.files = ele.files;

        if(ele.files.length > 0){
            $scope.fileInfo = ele.files[0].name;
        }else{
            $scope.fileInfo = "Please select an excel file.";
        }
        $scope.$apply();
    };

    $scope.uploadFile = function(){
        if($scope.files == undefined){
            alert("Please select an excel file.")
            return ;
        }
        $scope.dataLoading = true;
        services.importUsers($scope.files[0])
        .then(function (result) {
            $scope.dataLoading = false;
            if(result.code == '1'){
                alert("Upload User Excel Success")
            }else{
                alert(result.message) ;
            }
        });
    };
}