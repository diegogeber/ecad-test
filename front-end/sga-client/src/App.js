import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import api from './api';

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

class App extends Component{
  test(){
    
  }
  state = {
    results: [],
  }

  async componentDidMount(){
    const response = await api.get('');
    console.log(response.data);
    this.setState({ results: response.data})
  }

  render(){
    const {results} = this.state;
    
    return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Usuário</TableCell>
            <TableCell align="right">CPF/CNPJ</TableCell>
            <TableCell align="right">Numero do Boleto</TableCell>
            <TableCell align="right">Tipo de Ocorrencia</TableCell>
            <TableCell align="right">Data Ocorrencia</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {results.map((result) => (
            <TableRow key={result.userName}>
              <TableCell component="th" scope="row">
                {result.userName}
              </TableCell>
              <TableCell align="right">{result.cpfCnpj}</TableCell>
              <TableCell align="right">{result.slipNumber}</TableCell>
              <TableCell align="right">{result.occurrenceType}</TableCell>
              <TableCell align="right">{result.occurrenceDate}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>

    ); 
  }
}

export default App;
