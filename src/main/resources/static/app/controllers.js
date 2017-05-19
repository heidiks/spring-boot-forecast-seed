(function(angular) {
  var AppController = function($scope, $http, City) {

    get = function() {
        City.query(response => $scope.cities = response ? response : []);
    };

    onError = function(res) {
        alert(res.data.message);
    };

    onSuccess = function(res) {
        get();
        alert("City saved!");
    };

    $scope.saveOrUpdate = function(newCity) {
      let city = new City({
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
        if(confirm(`Do you really wanto to delete ${city.name}?`))
            city.$remove(() => $scope.cities.splice($scope.cities.indexOf(city), 1));
    };

    $scope.forecast = function(city) {
        $http.get(`/api/cities/${city.id}/forecast`).
        then(function(response) {
            console.info(response);
        });
    };

    get();
  };
  
  AppController.$inject = ['$scope', '$http', 'City'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));