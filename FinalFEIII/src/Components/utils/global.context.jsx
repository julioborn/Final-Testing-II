import { useReducer,useMemo,useContext,createContext } from "react";
import { reducer } from "../../reducer.jsx";

export const initialState = {theme: "", data: []}

export const ContextGlobal = createContext(undefined);

export const ContextProvider = ({ children }) => {
  const [state,dispatch] = useReducer(reducer,initialState);

  const providerValue = useMemo(()=>({state,dispatch}),[state,dispatch]);
  return (
    <ContextGlobal.Provider value={providerValue}>
      {children}
    </ContextGlobal.Provider>
  );
};

export const useContextGlobal = () => {
  return useContext(ContextGlobal);
};