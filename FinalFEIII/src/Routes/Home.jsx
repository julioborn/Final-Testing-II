import React from 'react'
import { useEffect } from 'react';
import Card from '../Components/Card'
import { useContextGlobal } from '../Components/utils/global.context'

const Home = () => {
  const { state, dispatch } = useContextGlobal();

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(resp => resp.json())
      .then(arrayDocs => dispatch({ type: 'guardar-dentistas', payload: arrayDocs }))
      .catch(err => console.log(err))
  }, [dispatch])

  return (
    <main className={state.theme}>
      <br />
      <h2>Dentistas</h2>
      <div className='card-grid'>
        {state.data.map(
          e =>
            <Card
              key={e.id}
              name={e.name}
              username={e.username}
              id={e.id}
            />
        )}
      </div>
    </main>
  )
}

export default Home