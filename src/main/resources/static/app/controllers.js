(function(angular) {
  var AppController = function($scope, City) {
      City.query(function(response) {
      $scope.cities = response ? response : [];
    });
    
    $scope.add = function(newCity) {
      new City({
        name: newCity.name,
        country: newCity.country
      }).$save(function(city) {
        $scope.cities.push(city);
      });
      $scope.newCity = "";
    };
    
    $scope.update = function(city) {
        city.$update();
    };
    
    $scope.delete = function(city) {
        city.$remove(function() {
        $scope.cities.splice($scope.cities.indexOf(city), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'City'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));