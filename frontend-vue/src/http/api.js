import request from './request.js'

//直接声明一个URL存储接口地址
const URL = {
    GET_IDIOM_BY_ID: '/idiom/queryById',
    GET_IDIOM_BY_WORD: '/idiom/queryByWord'
};

export default {
    queryById({ id }) {
        return request(URL.GET_IDIOM_BY_ID, 'GET', { id });
    },
    queryByWord({ word }) {
        return request(URL.GET_IDIOM_BY_WORD, 'GET', { word });
    },
};