//See: https://github.com/pablojim/highcharts-ng
var myapp = angular.module('myapp', []);

myapp.controller('myctrl', ['$scope','$http', function($scope, $http)  {

     $scope.lookup = function() {
                               $http.get('/parceltrack/3.0/parcels/' + $scope.trackingReference)
                                                                                        .then(function(response) {
                                      if(response.status == 200) {
                                          console.log("Response " + JSON.stringify(response.data));
                                          $scope.events = response.data.results.tracking_events;
                                        }
                                });
         }
}]);