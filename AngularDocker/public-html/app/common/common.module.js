/**
 * Created by Nada on 17-Apr-2016.
 */

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

//angular.module('ngservices', ['ngResource','webServicesConstant'])
//
//.factory('GetJSonMI', function ($resource) {
//        return $resource('../MI/json_addons.json', {}, {
//            query: { method: 'GET' , cache : false},
//            post: {method:'POST'},
//            update: {method:'PUT'},
//            remove: {method:'DELETE'}
//        })
//    }
//)
//
//.factory('checkLogin',['$resource',function ($resource) {
//        return $resource('http://localhost:3000/validData?userid=:id&password=:password',{}, {
//        //return $resource('http://localhost:3000/validData?',{}, {
//            query: { method: 'GET' ,
//                params:{id:'@id', password: '@password'},
//                cache : false ,isArray: true },
//
//            post: {method:'POST'},
//            update: {method:'PUT'},
//            remove: {method:'DELETE'}
//        })
//    }]
//);
