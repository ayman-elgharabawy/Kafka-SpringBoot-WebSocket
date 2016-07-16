angular.module("app.login", ['webServicesConstant', 'app.common'])
    .controller("loginController", ['$scope', 'checkLogin', 'wsConstant', '$state', function ($scope, checkLogin, wsConstant, $state) {
        $scope.user = { MobileNum: '', password: '' };
        $scope.submit = function () {
            wsConstant.MobileNum = $scope.user.MobileNum;
            wsConstant.password = $scope.user.password;
            checkLogin.checkLoginSuccess(function (response) {
                console.log("login response -=====>>" + response);
                // alert("response.length "+response.length);
                if (response.length = 1) {
                    $state.go('profile');
                }
                else {
                    $('.ErrorMsg').css('display', 'block');
                }
            });
            //-------------------- reset inputfields ------------------
            $scope.user = { MobileNum: '', password: '' };
        };
    }])
