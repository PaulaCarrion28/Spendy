import { useEffect, useState } from "react";
import { endpoints } from "../services/api";

const Dashboard = () => {

    const [gastos, setGastos] = useState([]);

    useEffect(() => {

        fetch(endpoints.gastos)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setGastos(data);
            })
            .catch(error => console.log(error));

    }, []);

    const totalGastado = gastos.reduce(
        (acumulador, gasto) => acumulador + gasto.valor,
        0
    );

    return (
        <div
            style={{
                minHeight: "100vh",
                background: "#0f172a",
                paddingTop: "40px",
                paddingBottom: "40px",
                paddingLeft: "20px",
                paddingRight: "20px",
                boxSizing: "border-box"
            }}
        >

            <div
                style={{
                    maxWidth: "1200px",
                    margin: "0 auto"
                }}
            >

                <h1
                    style={{
                        color: "white",
                        fontSize: "42px",
                        marginBottom: "10px"
                    }}
                >
                    Spendy Dashboard
                </h1>

                <p
                    style={{
                        color: "#94a3b8",
                        marginBottom: "40px",
                        fontSize: "18px"
                    }}
                >
                    Control de gastos personales
                </p>

                {/* TARJETAS */}

                <div
                    style={{
                        display: "grid",
                        gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
                        gap: "20px",
                        marginBottom: "40px"
                    }}
                >

                    <div
                        style={{
                            background: "#1e293b",
                            padding: "25px",
                            borderRadius: "20px",
                            color: "white"
                        }}
                    >
                        <h3>Total Gastado</h3>

                        <h2 style={{ marginTop: "15px" }}>
                            ${totalGastado.toLocaleString()}
                        </h2>
                    </div>

                    <div
                        style={{
                            background: "#1e293b",
                            padding: "25px",
                            borderRadius: "20px",
                            color: "white"
                        }}
                    >
                        <h3>Número de Gastos</h3>

                        <h2 style={{ marginTop: "15px" }}>
                            {gastos.length}
                        </h2>
                    </div>

                </div>

                {/* LISTA DE GASTOS */}

                <h2
                    style={{
                        color: "white",
                        marginBottom: "20px"
                    }}
                >
                    Últimos Gastos
                </h2>

                <div
                    style={{
                        display: "grid",
                        gridTemplateColumns: "repeat(auto-fit, minmax(300px, 1fr))",
                        gap: "20px"
                    }}
                >

                    {gastos.map(gasto => (

                        <div
                            key={gasto.id}
                            style={{
                                background: "#1e293b",
                                borderRadius: "20px",
                                padding: "20px",
                                color: "white",
                                boxShadow: "0px 4px 10px rgba(0,0,0,0.3)"
                            }}
                        >

                            <h3
                                style={{
                                    marginBottom: "10px",
                                    fontSize: "22px"
                                }}
                            >
                                {gasto.nombre}
                            </h3>

                            <p>
                                <strong>Valor:</strong> $
                                {gasto.valor.toLocaleString()}
                            </p>

                            <p>
                                <strong>Descripción:</strong>
                                {" "}
                                {gasto.descripcion}
                            </p>

                            <p>
                                <strong>Ubicación:</strong>
                                {" "}
                                {gasto.ubicacion}
                            </p>

                            <p>
                                <strong>Fecha:</strong>
                                {" "}
                                {gasto.fecha}
                            </p>

                            <div
                                style={{
                                    marginTop: "15px",
                                    display: "inline-block",
                                    background:
                                        gasto.esNecesario
                                            ? "#16a34a"
                                            : "#dc2626",
                                    padding: "8px 14px",
                                    borderRadius: "999px",
                                    fontSize: "14px"
                                }}
                            >
                                {gasto.esNecesario
                                    ? "Necesario"
                                    : "No Necesario"}
                            </div>

                        </div>

                    ))}

                </div>

            </div>

        </div>
    );
}

export default Dashboard;