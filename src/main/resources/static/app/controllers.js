(function(angular) {
  var AppController = function($scope, City, toaster) {

    get = function() {
        City.query(response => $scope.cities = response ? response : []);
    };

    onError = function(res) {
        console.info(res.data.message);
        console.info(res);
    };

    onSuccess = function(res) {
        console.info("City saved!");
        get()
    };

    $scope.saveOrUpdate = function(newCity) {
      var city = new City({
          id: newCity.id,
          name: newCity.name,
          country: newCity.country
      });

      if(!newCity || !newCity.id) city.$save(onSuccess, onError);
      else city.$update(onSuccess, onError);

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