import axios from 'axios';

const APIKey = '2MCP7YJJ-etjT0Mj5aB7skyln1iue4QI-4HuaG5GIt935jt_DfEz3fuoDSdERXDuQWre6R3qUcNDGaTP8olxLBzg4Fh-__QCTQ8zsCAT1xFX84_klZ0_Cc_3x4yqYXYx'
const corsApiUrl = 'https://cors-anywhere.herokuapp.com/';


const http = axios.create({
    baseURL: `${corsApiUrl}https://api.yelp.com/v3/businesses`,
    // https://api.yelp.com/v3/businesses
    headers: {
        Authorization: `Bearer ${APIKey}`
        }
});

export default {

    getSingleRestaurant(businessID) {
        return http.get(`/${businessID}`)
    },

    getSearchResults(cuisine, zipcode, meters) {
        return http.get(`/search?term=${cuisine}&location=${zipcode}&radius=${meters}`)
    }

}