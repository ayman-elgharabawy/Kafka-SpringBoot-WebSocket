angular.module('app.common', ['webServicesConstant'])

    .factory('GetJSonMI',['$http', function ($http){
    var allData= null;
    var getallData = function(callBack){

        $http.get('/poc-backend/MI?').
            then(function(respond){
                allData = angular.fromJson(respond.data);
                console.log(allData);
                callBack(allData);
            }, function(respond) {
            })
    }

    return {
        getAllLocations: getallData
    }

}])
.factory('checkLogin',['$http','wsConstant', function ($http,wsConstant){

    var returned= null;
    var getResponse = function(callBack){
       //console.log(wsConstant.MobileNum);
        $http.post('/poc-backend/auth/validData?userid='+wsConstant.MobileNum+'&password='+wsConstant.password).
            then(function(respond){
                returned = respond.data;
                callBack(returned);
            }, function(respond) {
            })
    }

    return {
        checkLoginSuccess: getResponse
    }

}]);
