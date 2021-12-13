import axios from 'axios';

const http = axios.create({
    baseURL: "https://api.yelp.com/v3/businesses",
    headers: {
        common: {
            'Authorization': 'Bearer 2MCP7YJJ-etjT0Mj5aB7skyln1iue4QI-4HuaG5GIt935jt_DfEz3fuoDSdERXDuQWre6R3qUcNDGaTP8olxLBzg4Fh-__QCTQ8zsCAT1xFX84_klZ0_Cc_3x4yqYXYx' 
        }
    }
});

export default {

    getSingleRestaurant(businessID) {
        return http.get(`/${businessID}`)
    },

    getSearchResults(cuisine, zipcode, meters) {
        return http.get(`search?term=${cuisine}&location=${zipcode}&radius=${meters}`)
    }

}