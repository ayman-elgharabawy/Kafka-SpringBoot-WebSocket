/**
 * Created by Nada on 21-Mar-2016.
 */

angular.module("app.mi", ['app.common', 'ngStomp'])
    .controller("miController", ['$scope', 'GetJSonMI', 'wsConstant', '$stomp', function ($scope, GetJSonMI, wsConstant, $stomp) {

        // GetJSonMI.getAllLocations(function (allLoc) {
        //     $scope.AllMIData = allLoc;

        // });

        //Working with STOMP
        // $stomp.setDebug(function (args) {
        //     $log.debug(args)
        // })
        
        emps = { MobileNum: wsConstant.MobileNum };

        $scope.UserData = emps;
        var loadingText = "loading ..."
        $scope.mobileInternet = {usbMsisdn:loadingText, balance: loadingText, sallefny: loadingText, ratePlan: loadingText, consumedQouta: 0, totalQouta: 0}
        
        $scope.adsText = "Stay tuned for new offers ..."
        $stomp
            .connect('/poc-backend/ws', {})

            // frame = CONNECTED headers
            .then(function (frame) {
                var subscription = $stomp.subscribe('/user/topic/mi', function (payload, headers, res) {
                    $scope.mobileInternet = payload
                    $scope.$apply();
                }, {})
                    
                var adsSubscription = $stomp.subscribe('/topic/ads', function (payload, headers, res) {
                    $scope.adsText = payload.content
                    $scope.$apply();
                }, {})

                // Unsubscribe
                //subscription.unsubscribe()

                // Send message
                $stomp.send('/app/mi', {
                    username: $scope.UserData.MobileNum
                }, {})

                // Disconnect
                // $stomp.disconnect(function () {
                //     $log.info('disconnected')
                // })
            })


        $scope.GetValueInGB = function (Value) {

            var diplayedValue = Value;

            if (Value > 1024 && Value < 1024 * 1024) {
                // MByte
                diplayedValue = parseInt((Value / 1024));

            }
            else if (Value > 1024 * 1024) {
                //GByte
                diplayedValue = parseInt(Value / (1024 * 1024));
            }

            return diplayedValue;
        };
        $scope.GetDisplayedUnit = function (Value) {

            var diplayedUnit = 'KB';

            if (Value > 1024 && Value > 1024 * 1024) {
                // MByte
                diplayedUnit = 'MB';

            }
            else if (Value > 1024 * 1024) {
                //GByte
                diplayedUnit = 'GB';
            }

            return diplayedUnit;
        };
        $scope.setprogerress = function (id, value) {
            return {
                width: value + "%",
                transition: "width 20s linear"
            };

        };
    }])






