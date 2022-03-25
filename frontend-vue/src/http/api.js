import request from './request.js'

//直接声明一个URL存储接口地址
const URL = {
    GET_IDIOM_BY_ID: '/idiom/queryById'
};

export default {
    queryById({ id }) {
        return request(URL.GET_IDIOM_BY_ID, 'GET', { id });
    },
};