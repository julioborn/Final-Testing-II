export const reducer = (state,action) =>{
    switch(action.type){
      case 'dark':
        return {...state,theme:"dark"}
      case 'light':
        return {...state,theme:""}
      case 'guardar-dentistas':
        return {...state,data: action.payload}
      default:
        return {...state}
    }
}