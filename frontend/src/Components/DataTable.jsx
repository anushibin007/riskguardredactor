import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const DataTable = () => {
  const rows = [
    { sno: 1, name: "John", file: "document1.pdf" },
    { sno: 2, name: "Jane", file: "document2.pdf" },
    { sno: 3, name: "Alice", file: "document3.pdf" },
    { sno: 4, name: "Bob", file: "document4.pdf" },
    { sno: 5, name: "Eve", file: "document5.pdf" },
  ];

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>SNO</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>File</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.sno}>
              <TableCell>{row.sno}</TableCell>
              <TableCell>{row.name}</TableCell>
              <TableCell>{row.file}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default DataTable;
