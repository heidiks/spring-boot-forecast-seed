(function(angular) {
  var AppController = function($scope, City) {

    get = function() {
        City.query(response => $scope.cities = response ? response : []);
    };

    $scope.saveOrUpdate = function(newCity) {
      var city = new City({
          id: newCity.id,
          name: newCity.name,
          country: newCity.country
      });

      if(!newCity) city.$save(get);
      else city.$update(get);

      $scope.newCity = "";
    };

    $scope.edit = function(city) {
        $scope.newCity = angular.copy(city);
    };
    
    $scope.delete = function(city) {
        city.$remove(function() {
        $scope.cities.splice($scope.cities.indexOf(city), 1);
      });
    };

    get();
  };
  
  AppController.$inject = ['$scope', 'City'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));