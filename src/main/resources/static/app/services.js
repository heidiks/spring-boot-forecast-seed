(function (angular) {
    var CityFactory = function ($resource) {
        return $resource('api/cities/:id', {
                id: '@id'
            },
            {
                update: {
                    method: "PUT"
                },
                remove: {
                    method: "DELETE"
                }
            });
    };

    CityFactory.$inject = ['$resource'];
    angular.module("myApp.services").factory("City", CityFactory);
}(angular));