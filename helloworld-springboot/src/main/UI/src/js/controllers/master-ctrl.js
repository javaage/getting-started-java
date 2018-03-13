/**
 * Master Controller
 */

angular.module('RDash')
    .controller('MasterCtrl', ['$rootScope', '$scope', '$cookieStore', MasterCtrl]);

function MasterCtrl($rootScope, $scope, $cookieStore) {
    /**
     * Sidebar Toggle & Cookie Control
     */
    var mobileView = 992;

    $scope.getWidth = function() {
        return window.innerWidth;
    };

    $scope.$watch($scope.getWidth, function(newValue, oldValue) {
        if (newValue >= mobileView) {
            if (angular.isDefined($cookieStore.get('toggle'))) {
                $scope.toggle = ! $cookieStore.get('toggle') ? false : true;
            } else {
                $scope.toggle = true;
            }
        } else {
            $scope.toggle = false;
        }

    });

    $scope.toggleSidebar = function() {
        $scope.toggle = !$scope.toggle;
        $cookieStore.put('toggle', $scope.toggle);
    };

    window.onresize = function() {
        $scope.$apply();
    };

    // $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {
    //     console.log(event);
    //     console.log(toState);
    //     console.log(toParams);
    //     console.log(fromState);
    //     console.log(fromParams);
    //     console.log(error);    
    // });

    // $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
    //     console.log(event);
    //     console.log(toState);
    //     console.log(toParams);
    //     console.log(fromState);
    //     console.log(fromParams);   
    // });
}